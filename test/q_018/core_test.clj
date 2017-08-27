(ns q-018.core-test
  (:require [clojure.test :refer :all]
            [q-018.core :refer :all]))

(deftest q-018-test
  (is (= (-main) 1074)))
