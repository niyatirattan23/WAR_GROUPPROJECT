package ca.sheridancollege.project.test;

import ca.sheridancollege.project.TestPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testPlayerName() {
        // Arrange
        String expectedName = "Player1";
        TestPlayer player = new TestPlayer(expectedName);

        // Act
        String actualName = player.getName();

        // Assert
        assertEquals(expectedName, actualName, "The player name should be the same as the expected name");
    }

    @Test
    public void testSetName() {
        // Arrange
        TestPlayer player = new TestPlayer("OldName");
        String newName = "NewName";

        // Act
        player.setName(newName);

        // Assert
        assertEquals(newName, player.getName(), "The player name should be updated to the new name");
    }
}
