package christmas.model.domain.event;

import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static EventRepository instance;
    private final Map<Long, EventStrategy> eventRepository;
    private final Map<Long, Badge> badgeRepository;
    private long id;

    private EventRepository(Map<Long, EventStrategy> eventRepository, Map<Long, Badge> badgeRepository) {
        this.eventRepository = eventRepository;
        this.badgeRepository = badgeRepository;
        id = 0L;
    }

    public static EventRepository getEventRepository() {
        if (instance == null) {
            instance = new EventRepository(new HashMap<>(), new HashMap<>());
        }
        return instance;
    }

    public long save(EventStrategy eventStrategy) {
        long currentId = id++;
        eventRepository.put(currentId, eventStrategy);
        badgeRepository.put(currentId, eventStrategy.getBadge());
        return id;
    }

    public EventStrategy getEventResultsById(long id) {
        return eventRepository.get(id);
    }
}
