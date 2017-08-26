(ns q-014.core
  (:gen-class))

(defn collatz-next [n]
  (if (even? n)
    (/ n 2)
    (inc (* 3 n))))

(def collatz-sequence
  (memoize
    (fn [n]
      (if (= 1 n)
        (list 1)
        (cons n (collatz-sequence (collatz-next n)))))))

(defn collatz-sequence-length [n]
  (count (collatz-sequence n)))

(defn -main
  "Longest Collatz sequence"
  [& args]
  (def answer (->> (range 1 1e6)
                   (map #(list % (collatz-sequence-length %)))
                   (apply max-key second)
                   (first)))
  (println answer)
  answer)
