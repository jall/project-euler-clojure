(ns q-031.core-test
  (:require [clojure.test :refer :all]
            [q-031.core :refer :all]))

(deftest q-031-test
  (is (= (-main) 73682)))
