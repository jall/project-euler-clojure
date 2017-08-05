(ns q-003.core
  (:gen-class)
  (:require [numbers.primes :refer [prime-factors]]))

(defn -main
  "Largest prime factor"
  [& args]
  (def answer (apply max (prime-factors 600851475143)))
  (println answer)
  answer)
