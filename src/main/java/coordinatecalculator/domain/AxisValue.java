package coordinatecalculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AxisValue {
    private static final String INVALID_INPUT_FORMAT_MESSAGE = "좌표 값은 자연수여야 합니다.";
    private static final String INVALID_INPUT_BOUND_MESSAGE = "좌표 값은 0이상 24이하여야 합니다.";
    private static final int AXIS_LOWER_BOUND = 1;
    private static final int AXIS_UPPER_BOUND = 24;
    private static final Map<Integer, AxisValue> AXIS_VALUES = new HashMap<>();

    static {
        for (int i = AXIS_LOWER_BOUND; i <= AXIS_UPPER_BOUND; i++) {
            AXIS_VALUES.put(i, new AxisValue(i));
        }
    }

    private final int value;

    private AxisValue(final int value) {
        this.value = value;
    }

    public static AxisValue getAxisValue(String key) {
        checkNumeric(key);
        checkBoundary(Integer.parseInt(key));

        return AXIS_VALUES.get(Integer.parseInt(key));
    }

    public int getValue() {
        return this.value;
    }

    private static void checkNumeric(String input) {
        if (!input.matches("(\\d+)?")) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_MESSAGE);
        }
    }

    private static void checkBoundary(int input) {
        if (input < AXIS_LOWER_BOUND || input > AXIS_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_INPUT_BOUND_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxisValue axisValue1 = (AxisValue) o;
        return Objects.equals(value, axisValue1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
