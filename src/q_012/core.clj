(ns q-012.core
  (:gen-class)
  (:require [numbers.prime-factors :refer [prime-factors]]
            [numbers.triangle :refer [triangle-numbers]]
            [clojure.math.combinatorics :as combinatorics]))

(defn proper-divisors
  "Returns a map of all proper divisors of a number"
  [number]
  (set (map
         (partial apply *)
         (combinatorics/subsets (prime-factors number)))))

(defn over-500-divisors?
  [number]
  (< 500 (count (proper-divisors number))))

(defn -main
  "Highly divisible triangular number"
  [& args]
  (def answer (first (filter over-500-divisors? (triangle-numbers))))
  (println answer)
  answer)
