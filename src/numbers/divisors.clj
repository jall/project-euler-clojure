(ns numbers.divisors
  (:require [numbers.prime-factors :refer [prime-factors]]
            [clojure.math.combinatorics :as combinatorics]))

(defn proper-divisors
  "Returns a map of all proper divisors of a number"
  [number]
  (set (map
         (partial apply *)
         (combinatorics/subsets (prime-factors number)))))
