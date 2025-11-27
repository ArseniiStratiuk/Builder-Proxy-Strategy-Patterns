package apps.ucu.ooad.task1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    @NonNull
    private final String name;

    @Builder.Default
    private final int age = 0;

    private final Gender gender;

    @Builder.Default
    private final double weight = 0;

    @Builder.Default
    private final double height = 0;
}

enum Gender {
    MALE, FEMALE
}