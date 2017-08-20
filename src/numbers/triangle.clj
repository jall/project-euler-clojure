(ns numbers.triangle)

(defn triangle-number [n]
  (apply +' (range 1 (inc n))))

(defn triangle-numbers
  "Lazy sequence of triangle numbers"
  []
  (map triangle-number (iterate inc 1)))
