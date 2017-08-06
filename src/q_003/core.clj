(ns q-003.core
  (:gen-class)
  (:require [numbers.prime-factors :refer [prime-factors]]))

(defn -main
  "Largest prime factor"
  [& args]
  (def answer (apply max (prime-factors 600851475143)))
  (println answer)
  answer)
