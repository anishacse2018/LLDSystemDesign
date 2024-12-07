package strategy;

public class SearchStrategySelectionFactory {
    public static SearchStrategy selectStrategy(String strategy){
        if(strategy.equals(SearchStrategyType.LISTING_TYPE)){
            return new ListingTypeSearch();
        }else if(strategy.equals(SearchStrategyType.ROOM_TYPE)){
            return new RoomTypeSearchStrategy();
        }else if(strategy.equals(SearchStrategyType.PRICE)){
            return new PriceRangeSearchStrategy();
        }else if(strategy.equals(SearchStrategyType.SIZE)){
            return new SizeRangeSearchStrategy();
        }else if(strategy.equals(SearchStrategyType.LOCATION)){
            return new LocationBasedSearch();
        }
        return new CompositeSearchStrategy();
    }
}
