(ns numbers.fibonacci)

(defn fibonacci
  ([]
   (fibonacci 1 2))
  ([n-1 n]
   (lazy-seq (cons n-1 (fibonacci n (+' n-1 n))))))
