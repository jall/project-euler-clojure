(ns q-021.core
  (:gen-class)
  (:require [numbers.divisors :refer [proper-divisors]]))

(def d
  (memoize
   (fn [n]
     (if (zero? n)
       0
       (->> (proper-divisors n)
            (apply +))))))

(defn amicable? [a]
  (let [b (d a)]
    (and (not= a b)
         (= (d b) a))))

(defn -main
  "Amicable numbers"
  [& args]
  (def answer (->> (range 1 10001)
                   (filter amicable?)
                   (apply +)))
  (println answer)
  answer)
