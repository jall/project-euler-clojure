(ns numbers.factorial)

(defn factorial [n]
  (reduce *' (range 2 (inc n))))

(defn falling-factorial
  "n(n-1)(n-2)...(n-(k-1))"
  [n k]
  (reduce *' (map #(- n %) (range k))))
