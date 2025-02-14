package com.railway.wheeldashboard.wheelPohDetail;


import com.railway.wheeldashboard.common.PageableModel;
import com.railway.wheeldashboard.common.SortModel;

import java.util.List;

public class WheelPohResponse {

        private List<WheelPohModel> content;  // List of axle rejection records
        private PageableModel pageable;
        private boolean last;
        private int totalPages;
        private long totalElements;
        private int size;
        private int number;
        private SortModel sort;
        private boolean first;
        private int numberOfElements;
        private boolean empty;

        public List<WheelPohModel> getContent() {
            return content;
        }

        public void setContent(List<WheelPohModel> content) {
            this.content = content;
        }

        public PageableModel getPageable() {
            return pageable;
        }

        public void setPageable(PageableModel pageable) {
            this.pageable = pageable;
        }

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public SortModel getSort() {
            return sort;
        }

        public void setSort(SortModel sort) {
            this.sort = sort;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public boolean isEmpty() {
            return empty;
        }

        public void setEmpty(boolean empty) {
            this.empty = empty;
        }
    }


