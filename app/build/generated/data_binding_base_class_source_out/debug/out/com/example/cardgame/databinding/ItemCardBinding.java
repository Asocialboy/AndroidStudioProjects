// Generated by view binder compiler. Do not edit!
package com.example.cardgame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cardgame.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemCardBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivCard;

  @NonNull
  public final TextView tvCardSuit;

  @NonNull
  public final TextView tvCardValue;

  private ItemCardBinding(@NonNull LinearLayout rootView, @NonNull ImageView ivCard,
      @NonNull TextView tvCardSuit, @NonNull TextView tvCardValue) {
    this.rootView = rootView;
    this.ivCard = ivCard;
    this.tvCardSuit = tvCardSuit;
    this.tvCardValue = tvCardValue;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_card;
      ImageView ivCard = ViewBindings.findChildViewById(rootView, id);
      if (ivCard == null) {
        break missingId;
      }

      id = R.id.tv_card_suit;
      TextView tvCardSuit = ViewBindings.findChildViewById(rootView, id);
      if (tvCardSuit == null) {
        break missingId;
      }

      id = R.id.tv_card_value;
      TextView tvCardValue = ViewBindings.findChildViewById(rootView, id);
      if (tvCardValue == null) {
        break missingId;
      }

      return new ItemCardBinding((LinearLayout) rootView, ivCard, tvCardSuit, tvCardValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}