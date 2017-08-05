(ns q-006.core
  (:gen-class))

(defn square [number]
  (* number number))

(defn sumOfSquares [numbers]
  (apply + (map square numbers)))

(defn squareOfSum [numbers]
  (square (apply + numbers)))

(defn -main
  "Sum square difference"
  [& args]
  (def answer (- (squareOfSum (range 1 101)) (sumOfSquares (range 1 101))))
  (println answer)
  answer)
