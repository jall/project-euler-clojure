(ns numbers.pythagorean-triple
  (:gen-class)
  (:require [clojure.math.numeric-tower :refer [gcd]]))

(defn co-prime? [a b]
  (= (gcd a b) 1))

(defn pythagorean-triples-from-seed
  [n m]
  (list
    (- (* m m) (* n n))
    (* 2 m n)
    (+ (* m m) (* n n))))

(defn pythagorean-triples-primitive
  ([limit]
   (pythagorean-triples-primitive limit 1 2 '()))
  ([limit n m triples]
   (if
     (< limit n)
     triples
     (if
       (< limit m)
       (recur limit (+ n 1) (+ n 2) triples)
       (if
         (and (not (and (odd? n) (odd? m)))
              (co-prime? n m))
         (recur limit n (inc m) (cons (pythagorean-triples-from-seed n m) triples))
         (recur limit n (inc m) triples))))))

(defn pythagorean-triples
  [limit multiples]
  (for [k (range 1 (inc multiples))
        triple (pythagorean-triples-primitive limit)]
    (map #(* k %) triple)))

