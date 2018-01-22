(ns q-031.core
  (:gen-class))

(defn restricted-set-partition
  ([target set]
   (restricted-set-partition target set (list)))
  ([target set partition]
   (cond
     (zero? (count set)) (list)
     (< target 0) (list)
     (zero? target) (list partition)
     :else (concat
             (restricted-set-partition (- target (first set)) set (conj partition (first set)))
             (restricted-set-partition target (rest set) partition))
     )))

(defn -main
  "Coin sums"
  [& args]
  (let [answer (count (restricted-set-partition 200 [200 100 50 20 10 5 2 1]))]
    (println answer)
    answer))
