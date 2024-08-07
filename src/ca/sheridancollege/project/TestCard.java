package ca.sheridancollege.project;

/**
 * A concrete subclass of Card for testing purposes.
 */
public class TestCard extends Card {

    private String description;

    public TestCard(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
