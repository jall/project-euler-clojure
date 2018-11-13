(ns q-006.core-test
  (:require [clojure.test :refer :all]
            [q-006.core :refer :all]))

(deftest q-006-test
  (is (= (-main) 25164150)))
