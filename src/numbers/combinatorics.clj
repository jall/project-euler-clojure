(ns numbers.combinatorics
  (:require [numbers.factorial :refer :all]))

(defn binomial-coefficient
  "The binomial coefficient n choose k"
  [n k]
  (/ (falling-factorial n k)
     (factorial k)))
