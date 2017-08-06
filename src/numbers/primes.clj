(ns numbers.primes)

; Shamelessly stolen from https://stackoverflow.com/a/16273847
; I like this one because it's pure Clojure & I can actually understand it,
; plus it's pretty quick.
; My original attempt at a lazy seq of primes did work but it was shockingly slow.
; I think my problem was dividing all candidate numbers by all primes found so far,
; plus there were almost certainly inefficiencies in my Clojure style.

(defn cleanse
  "Walks through the sieve and nils out multiples of step"
  [primes step i]
  (if (<= i (count primes))
    (recur
      (assoc! primes i nil)
      step
      (+ i step))
    primes))

(defn sieve-step
  "Only works if i is >= 3"
  [primes i]
  (if (< i (count primes))
    (recur
      (if (nil? (primes i)) primes (cleanse primes (* 2 i) (* i i)))
      (+ 2 i))
    primes))

(defn prime-sieve
  "Returns a lazy list of all primes smaller than x"
  [limit]
  (drop 2
        (filter (complement nil?)
                (persistent! (sieve-step
                               (cleanse (transient (vec (range limit))) 2 4) 3)))))

; This version is even more interesting; uses Java's BigInteger#isProbablePrime
; https://stackoverflow.com/a/7941430
; Change the certainty value to increase the likelihood that numbers are prime
; (makes it slower, obviously).
; Uses the Miller-Rabin primality test under the hood
; https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test

(def certainty 5)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) certainty))

(defn probably-prime-sieve
  "docstring"
  [limit]
  (concat [2] (take limit
                    (filter prime?
                            (take-nth 2
                                      (range 1 Integer/MAX_VALUE))))))

