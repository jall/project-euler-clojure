(ns numbers.perfect
  (:require [numbers.divisors :refer [proper-divisors]]))

(defn aliquot-sum
  "The sum of the proper divisors of a number"
  [n]
  (apply + (proper-divisors n)))

(defn perfect? [n]
  (= n (aliquot-sum n)))

(defn abundant? [n]
  (< n (aliquot-sum n)))

(defn deficient? [n]
  (> n (aliquot-sum n)))
