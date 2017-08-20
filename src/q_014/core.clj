(ns q-014.core
  (:gen-class))

(def collatz-next
  (memoize (fn [n]
             (if (even? n)
               (/ n 2)
               (inc (* 3 n))))))

(defn collatz-sequence
  ([n]
    (collatz-sequence n [n]))
  ([n seq]
   (if (= 1 n)
     seq
     (let [next (collatz-next n)]
       (recur next (conj seq next))))))

(defn collatz-sequence-length [n]
  (count (collatz-sequence n)))

; TODO This is very slow (~70s), figure out how to speed up
(defn -main
  "Longest Collatz sequence"
  [& args]
  (def answer (->> (range 1 1e6)
                   (map #(list % (collatz-sequence-length %)))
                   (apply max-key second)
                   (first)))
  (println answer)
  answer)
