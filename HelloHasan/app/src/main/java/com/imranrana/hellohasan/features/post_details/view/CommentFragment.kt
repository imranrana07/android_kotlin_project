package com.imranrana.hellohasan.features.post_details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.imranrana.hellohasan.R


class CommentFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.comment_dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val bottomSheet: View = view.findViewById(R.id.recyclerView_commentLayout)
//        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
//        behavior.peekHeight = 700
    }

}