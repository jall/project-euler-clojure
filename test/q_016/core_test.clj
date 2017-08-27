(ns q-016.core-test
  (:require [clojure.test :refer :all]
            [q-016.core :refer :all]))

(deftest q-016-test
  (is (= (-main) 1366)))
