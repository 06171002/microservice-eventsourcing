package org.example;

public class GenderRule implements Rule {

    private String gender;

    public GenderRule(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean isSatisfied(Customer customer) {
        if (this.gender.equals(customer.getGender())) {
            return true;
        }
        return false;
    }

    @Override
    public int compare(Customer before, Customer after) {
        return before.getGender()
                .compareTo(after.getGender());
    }
}
