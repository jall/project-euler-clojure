(ns q-010.core
  (:gen-class)
  (:require [numbers.primes :refer [prime-sieve]]))

(defn -main
  "Summation of primes"
  [& args]
  (def answer (apply + (prime-sieve 2e6)))
  (println answer)
  answer)
