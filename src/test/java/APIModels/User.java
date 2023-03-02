package APIModels;

import lombok.Data;

@Data
public class User {
    private String userID;
    private String username;
    private Books books[];
}
