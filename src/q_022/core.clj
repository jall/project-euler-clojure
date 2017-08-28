(ns q-022.core
  (:gen-class)
  (:require [clojure.string :as string]))

(defn name->score [name]
  (->> (char-array name)
       ; Integer representations for capital letters are 65-90
       (map #(- (int %) 64))
       (apply +)))

(defn -main
  "Names scores"
  [& args]
  (def answer (as-> (slurp "src/q_022/names.txt") names
                    (string/replace names "\"" "")
                    (string/split names #",")
                    (sort names)
                    (into [] names)
                    (map-indexed (fn [index name]
                                   (* (inc index) (name->score name)))
                                 names)
                    (apply + names)))
  (println answer)
  answer)
