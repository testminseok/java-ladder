package nextstep;

import java.util.ArrayList;
import java.util.List;

import static nextstep.constant.Constant.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(false);
        }
    }

    public void mark(int target) {
        points.set(target, true);
    }

    public void mark() {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, RAND.nextBoolean());
        }
        long count = points.stream()
                .filter(s -> s == true)
                .count();
        if (count == 0) {
            points.set((RAND.nextInt(points.size())), true);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public String lineString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < points.size(); i++) {
            stringBuilder.append("|");
            if (points.get(i)) {
                stringBuilder.append(HORIZON_LADDER_STRING);
            } else {
                stringBuilder.append(EMPTY_LADDER_STRING);
            }
            if (i == points.size() - 1) {
                stringBuilder.append("|");
            }
        }
        return stringBuilder.toString();
    }
}
