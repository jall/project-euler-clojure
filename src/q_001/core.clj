(ns q-001.core
  (:gen-class))

(defn multipleOf3Or5? [number]
  (or (= 0 (mod number 3)) (= 0 (mod number 5))))

(defn getMultiplesOf3Or5 [limit]
  (filter multipleOf3Or5? (range 1 limit)))

(defn sumOfMultiplesOf3And5 [limit]
  (apply + (getMultiplesOf3Or5 limit)))

(defn -main
  "Multiples of 3 and 5"
  [& args]
  (def answer (sumOfMultiplesOf3And5 1000))
  (println answer)
  answer)
