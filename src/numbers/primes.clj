(ns numbers.primes   (:gen-class)
  (:require [numbers.prime-factors :refer [divisible-by?]]))

(defn range-from
  "Infinite seq starting from specified value"
  [start]
  (iterate inc start))

(defn not-multiple-of [number]
  (complement (partial divisible-by? number)))

(defn filter-multiples
  "Remove multiples of a number from a seq"
  [number seq]
  (filter (not-multiple-of number) seq))

(defn candidate-range
  "Returns a range of numbers which aren't multiples of primes found so far"
  [primes]
  (reduce
    (fn [candidates prime]
      ; Apply filters all at once with some to reduce duplicate filtering?
      (filter-multiples prime candidates))
    (range-from (last primes))
    primes))

(defn prime-seq
  "An infinite lazy sequence of primes"
  ([]
   (cons 2 (prime-seq '(2))))
  ([primes]
   (let [prime (first (candidate-range primes))]
     (cons prime (lazy-seq (prime-seq (cons prime primes)))))))
