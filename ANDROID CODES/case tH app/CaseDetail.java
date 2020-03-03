package com.example.pranaw.casetrackinghandlingapp;

/**
 * Created by Pranaw on 22-07-2017.
 */

public class CaseDetail {
    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getJudgement() {
        return judgement;
    }

    public void setJudgement(String judgement) {
        this.judgement = judgement;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    private String clientid;
    private String casename;
    private String judgement;
    private String decision;

    @Override
    public String toString() {
        return  casename+""+clientid+""+judgement+""+decision;
    }


}
