(ns q-002.core
    (:gen-class))

(defn fibonacci
      ([]
       (fibonacci 1 2))
      ([n-1 n]
       (lazy-seq (cons n-1 (fibonacci n (+' n-1 n))))))

(defn even-fibonacci [] (filter even? (fibonacci)))

(defn -main
      "Even Fibonacci numbers"
      [& args]
      (def answer (apply +' (take-while #(<= % 4000000) (even-fibonacci))))
      (println answer)
      answer)
