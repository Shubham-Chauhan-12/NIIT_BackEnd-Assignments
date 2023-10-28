package org.companymgmt.domain;

public class Education {
    private String qualification;
    private String category;

    public Education() {
    }

    public Education(String qualification, String category) {
        this.qualification = qualification;
        this.category = category;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Education{" +
                "qualification='" + qualification + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
