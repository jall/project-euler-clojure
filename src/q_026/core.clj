(ns q-026.core
  (:gen-class)
  (:require [numbers.primes :refer [prime-sieve]]
            [numbers.pythagorean-triple :refer [co-prime?]]))

(defn multiplicative-order
  "http://mathworld.wolfram.com/MultiplicativeOrder.html
  This implementation taken from
  https://github.com/redacted/EulerClojure/blob/master/026.clj"
  [a n]
  (first (filter #(= 1 (.modPow (biginteger a) % (biginteger n)))
                 (map biginteger (iterate inc 1)))))

(defn -main
  "Reciprocal cycles"
  [& args]
  ; Only look at primes because we are only interested in reptend primes,
  ; which have cycle length of p-1 for a prime p.
  (let [answer (->> (prime-sieve 1000)
                    (filter #(co-prime? % 10))
                    (map #(vector % (multiplicative-order 10 %)))
                    (apply max-key second)
                    (first))]
    (println answer)
    answer))
