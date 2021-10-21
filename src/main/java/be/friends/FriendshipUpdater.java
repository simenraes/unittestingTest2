package be.friends;

public class FriendshipUpdater {

    final Friend[] friends;

    public FriendshipUpdater(Friend[] friends) {
        this.friends = friends;
    }

    public void updateFriendShipLevel(Friend friend) {
        if (friend.nrOfStars == 0 && friend.didSomeInteractionToday)
            friend.friendshipLevel -= 1;

        if (friend.didSomeInteractionToday && !friend.isLucky)
            friend.friendshipLevel += 1;
        else if (friend.didSomeInteractionToday)
            friend.friendshipLevel += 5;

        if (friend.friendshipLevel == 10 && friend.nrOfStars == 1)
            friend.friendshipLevel = 0;
        if (friend.friendshipLevel > 30)
            friend.friendshipLevel= 0;

        if (friend.friendshipLevel == 0 && friend.nrOfStars == 1)
            friend.nrOfStars += 1;
    }

    public void update() {
        for (Friend friend : friends) {
            boolean wasLucky = !friend.isLucky;
            if (friend.isLucky && friend.didSomeInteractionToday) {
                friend.isLucky = false;
            }

            updateFriendShipLevel(friend);
            if (friend.didSomeInteractionToday) {

                if (friend.nrOfStars == 0)
                    friend.nrOfStars++;
               else {
                    if (friend.friendshipLevel == 9) {
                       if (friend.nrOfStars == 1) {
//                           friend.friendshipLevel = -1;
//                           friend.nrOfStars = 2;
                      }
                    }

                }
                if (friend.nrOfStars != 3 && friend.friendshipLevel == 30) {
                    friend.friendshipLevel = 0;
                    friend.nrOfStars = friend.nrOfStars + 1;
                }
            }
            if (!wasLucky && !friend.didSomeInteractionToday) {
                friend.friendshipLevel -= 4;
            }
        }
    }


}


