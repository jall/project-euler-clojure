(ns q-012.core
  (:gen-class)
  (:require [numbers.divisors :refer [divisors]]
            [numbers.triangle :refer [triangle-numbers]]))

(defn over-500-divisors?
  [number]
  (< 500 (count (divisors number))))

(defn -main
  "Highly divisible triangular number"
  [& args]
  (def answer (first (filter over-500-divisors? (triangle-numbers))))
  (println answer)
  answer)
