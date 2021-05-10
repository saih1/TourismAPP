package com.saihtoo.tourismapp;

import java.util.List;

public class Data
{
    int[] imageList = {R.drawable.gor, R.drawable.opera, R.drawable.paradise, R.drawable.pinklake};
    String[] titleList = {
            "The Great Ocean Road",
            "The Opera House",
            "Surfers Paradise",
            "Lake Hillier"
    };

    String[] textList = {
            "The spectacular Great Ocean Road hugs the seaside cliffs that snake along the wild and windswept Southern Ocean. The striking vistas along the iconic road evoke awe with craggy cliffs, empty beaches and soaring bluffs flanked by brilliant green countryside. Add epic surf, native wildlife, unforgettable hiking and biking trails and you will find plenty of things to see and do around every corner.",
            "The Opera House is Sydney's best-known landmark. It is a multipurpose performing arts facility whose largest venue, the 2,679-seat Concert Hall, is host to symphony concerts, choir performances, and popular music shows.",
            "Australia's famous Surfers Paradise Beach lies at the heart of Queensland's Gold Coast. ... The beach itself is backed by a fenced fore-dune with plenty of signed access tracks from the esplanade to the sand and lined in seating areas and barbecues with ocean views for those wanting to just take it all in.",
            "Lake Hillier on Middle Island, Australia, is the color of bright-pink bubble gum. Researchers recently discovered that the lake's unique color is caused by algae, halobacteria, and other microbes."
    };

    public int getImage(int index)
    {
        return imageList[index];
    }

    public String getTitle(int index)
    {
        return titleList[index];
    }

    public String getText(int index)
    {
        return textList[index];
    }

    public int getLength()
    {
        return textList.length;
    }


}
