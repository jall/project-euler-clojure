(ns numbers.divisors
  (:require [numbers.prime-factors :refer [prime-factors]]
            [clojure.math.combinatorics :as combinatorics]))

(defn divisors
  "Returns a set of all proper divisors of a number"
  [number]
  (assert (< 0 number))
  (->> (prime-factors number)
       (combinatorics/subsets)
       (map (partial apply *))
       (set)))

(defn proper-divisors
  "Returns a set of all proper divisors of a number"
  [number]
  (assert (< 0 number))
  (disj (divisors number) number))
