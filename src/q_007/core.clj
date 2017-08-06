(ns q-007.core
  (:gen-class)
  (:require [numbers.primes :refer [prime-sieve probably-prime-sieve]]))

(defn -main
  "10001st prime"
  [& args]
  (def answer (nth (prime-sieve 2e6) 10000))
  (println answer)
  answer)
