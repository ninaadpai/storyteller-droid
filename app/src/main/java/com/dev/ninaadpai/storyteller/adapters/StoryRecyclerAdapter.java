package com.dev.ninaadpai.storyteller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.ninaadpai.storyteller.R;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.List;


/**
 * Created by ninaadpai on 6/5/17.
 */
//ca-app-pub-8600605129918183~7841512957
public class StoryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MENU_ITEM = 0;
    private static final int AD_ITEM = 1;
    private final Context mContext;
    private final List<Object> mRecyclerViewItems;
    private int flag = 0;
    public StoryRecyclerAdapter(Context mContext, List<Object> mRecyclerViewItems, int flag) {
        this.mContext = mContext;
        this.mRecyclerViewItems = mRecyclerViewItems;
        this.flag = flag;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case MENU_ITEM:
                default:
                    View menuItemView = LayoutInflater.from(viewGroup.getContext())
                            .inflate(R.layout.story_row, viewGroup, false);
                    return new MenuItemViewHolder(menuItemView);
            case AD_ITEM:
                View nativeExpressLayoutView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.ad_container, viewGroup, false);
                return new NativeAdViewHolder(nativeExpressLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType= getItemViewType(position);
        switch (viewType) {
            case MENU_ITEM:
                default:
                    MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
//                    MenuItem menuItem = (MenuItem) mRecyclerViewItems.get(position);
                    menuItemHolder.storyTitle.setText("Blah");
                    menuItemHolder.ownerName.setText("Blah");
                    menuItemHolder.startDate.setText("Blah");
                    menuItemHolder.hashTags.setText("Blah");
                    menuItemHolder.numOfAuthors.setText("Blah");
                    break;
            case AD_ITEM:
                NativeAdViewHolder nativeExpressHolder = (NativeAdViewHolder) holder;
                NativeExpressAdView adView = (NativeExpressAdView)mRecyclerViewItems.get(position);
                ViewGroup adCardView = (ViewGroup)nativeExpressHolder.itemView;
                adCardView.removeAllViews();
                if(adView.getParent() != null) {
                    ((ViewGroup)adView.getParent()).removeView(adView);
                }
                adCardView.addView(adView);
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        return (position %15 == 0 && position !=0) ? AD_ITEM : MENU_ITEM;
    }

    @Override
    public int getItemCount() {
        return mRecyclerViewItems.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView creatorImage, bookmarkButton;
        private TextView storyTitle, ownerName, startDate, hashTags, numOfAuthors;
        public MenuItemViewHolder(View itemView) {
            super(itemView);
            creatorImage = (ImageView)itemView.findViewById(R.id.creatorImage);
            bookmarkButton = (ImageView)itemView.findViewById(R.id.bookmarkButton);
            storyTitle = (TextView)itemView.findViewById(R.id.storyTitle);
            ownerName = (TextView)itemView.findViewById(R.id.ownerName);
            startDate = (TextView)itemView.findViewById(R.id.startDate);
            hashTags = (TextView)itemView.findViewById(R.id.hashTags);
            numOfAuthors = (TextView)itemView.findViewById(R.id.numOfAuthors);
        }
    }
    public class NativeAdViewHolder extends  RecyclerView.ViewHolder {
        public NativeAdViewHolder(View itemView) {
            super(itemView);
        }
    }
}

