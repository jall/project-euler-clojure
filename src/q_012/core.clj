(ns q-012.core
  (:gen-class)
  (:require [numbers.prime-factors :refer [prime-factors]]
            [clojure.math.combinatorics :as combinatorics]))

(defn triangle-numbers
  "Lazy sequence of triangle numbers"
  ([]
    (triangle-numbers '(1)))
  ([set]
    (let [previous (first set)
          increment (inc (count set))
          next (+' previous increment)]
      (lazy-seq (cons previous (triangle-numbers (cons next set)))))))

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
