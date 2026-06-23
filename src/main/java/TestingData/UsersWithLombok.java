package TestingData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //generate getter setter automatically
@Builder
public class UsersWithLombok {

        private String id;
        private String name;
        private String email;
        private String gender;
        private String status;
    }
