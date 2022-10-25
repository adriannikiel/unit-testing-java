package pl.anikiel.testing;

import org.junit.jupiter.api.Test;
import pl.anikiel.testing.order.Order;
import pl.anikiel.testing.order.OrderBackup;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingAFileFirstShouldThrowException() throws IOException {
        //given
        OrderBackup orderBackup = new OrderBackup();

        //then
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}
