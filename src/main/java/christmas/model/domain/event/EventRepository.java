package christmas.model.domain.event;

import christmas.model.domain.event.benefit.Badge;
import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private static EventRepository instance;
    private final Map<Long, EventResults> eventRepository;
    private final Map<Long, Badge> badgeRepository;
    private long id;

    private EventRepository(Map<Long, EventResults> eventRepository, Map<Long, Badge> badgeRepository) {
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

    public long save(EventResults eventResults) {
        long currentId = id++;
        eventRepository.put(currentId, eventResults);
        badgeRepository.put(currentId, eventResults.getBadge());
        return id;
    }

    public EventResults getEventResultsById(long id) {
        return eventRepository.get(id);
    }
}
