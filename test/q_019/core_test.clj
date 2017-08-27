(ns q-019.core-test
  (:require [clojure.test :refer :all]
            [q-019.core :refer :all]))

(deftest q-019-test
  (is (= (-main) 171)))
