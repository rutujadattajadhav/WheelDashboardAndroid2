package com.railway.wheeldashboard.breakdownhistory;

import java.util.List;

public class BreakdownHistoryResponse {
    private List<BreakdownHistory> content;
    private int totalPages;
    private int totalElements;
    private int number;

    public List<BreakdownHistory> getContent() { return content; }
    public int getTotalPages() { return totalPages; }
    public int getTotalElements() { return totalElements; }
    public int getNumber() { return number; }
}