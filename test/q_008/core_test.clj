(ns q-008.core-test
  (:require [clojure.test :refer :all]
            [q-008.core :refer :all]))

(deftest q-008-test
  (is (= (-main) 23514624000)))
