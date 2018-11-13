(ns q-027.core
  (:gen-class)
  (:require [numbers.primes :refer [prime?]]))

(defn quadratic-numbers
  ([a b] (quadratic-numbers a b 0))
  ([a b n]
   (lazy-seq (cons
              (+ (* n n) (* a n) b)
              (quadratic-numbers a b (inc n))))))

(defn consecutive-prime-count [a b]
  (count (take-while prime? (quadratic-numbers a b))))

(defn -main
  "Quadratic primes"
  [& args]
  (let [coefficients (->> (for [a (range -1000 1001)
                                b (range -1000 1001)]
                            {:a a :b b :consecutive-primes (consecutive-prime-count a b)})
                          (apply max-key :consecutive-primes))
        answer (* (coefficients :a) (coefficients :b))]
    (println coefficients)
    (println answer)
    answer))
